package com.ifanzero.mailreciever.service.impl;

import com.ifanzero.mailreciever.service.ReadMailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

@Slf4j
@Service
public class ReadMailServiceImpl {

//    @Override
    public void readMail() {
        Properties props = System.getProperties();
        props.setProperty("mail.store.protocol", "pop3");       // 协议
        props.setProperty("mail.pop3.port", "110");             // 端口
        props.setProperty("mail.pop3.host", "pop.126.com");    // pop3服务器
        Session session = Session.getInstance(props);
        Store store = null;
        try {
            store = session.getStore("pop3");
            store.connect("linyangfan940403@126.com", "+lin19940403+++");

            Folder folder = store.getFolder("INBOX");
        /* Folder.READ_ONLY：只读权限
         * Folder.READ_WRITE：可读可写（可以修改邮件的状态）
         */
            folder.open(Folder.READ_WRITE); //打开收件箱

            // 由于POP3协议无法获知邮件的状态,所以getUnreadMessageCount得到的是收件箱的邮件总数
            System.out.println("未读邮件数: " + folder.getUnreadMessageCount());

            // 由于POP3协议无法获知邮件的状态,所以下面得到的结果始终都是为0
            System.out.println("删除邮件数: " + folder.getDeletedMessageCount());
            System.out.println("新邮件: " + folder.getNewMessageCount());

            // 获得收件箱中的邮件总数
            System.out.println("邮件总数: " + folder.getMessageCount());

            // 得到收件箱中的所有邮件,并解析
            Message[] messages = folder.getMessages();
            parseMessage(messages);
            parseMessage1(folder);
            //释放资源
            folder.close(true);
            store.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void parseMessage1(Folder folder) {
        Message message;
        try {
            for (int j = folder.getMessageCount() - 1; j >= folder.getMessageCount() - 3; j--) {
                message = folder.getMessage(j);
                Multipart multipart = (Multipart) message.getContent();
                int count = multipart.getCount();    // 部件个数
                for (int i = 0; i < count; i++) {
                    // 单个部件     注意：单个部件有可能又为一个Multipart，层层嵌套
                    BodyPart part = multipart.getBodyPart(i);
                    // 单个部件类型
                    String type = part.getContentType().split(";")[0];
                    /**
                     * 类型众多，逐一判断，其中TEXT、HTML类型可以直接用字符串接收，其余接收为内存地址
                     * 可能不全，如有没判断住的，请自己打印查看类型，在新增判断
                     */
                    if (type.equals("multipart/alternative")) {        // HTML （文本和超文本组合）
                        System.out.println("超文本:" + part.getContent().toString());
                    } else if (type.equals("text/plain")) {    // 纯文本
                        System.out.println("纯文本:" + part.getContent().toString());
                    } else if (type.equals("text/html")) {    // HTML标签元素
                        System.out.println("HTML元素:" + part.getContent().toString());
                    } else if (type.equals("multipart/related")) {    // 内嵌资源 (包涵文本和超文本组合)
                        System.out.println("内嵌资源:" + part.getContent().toString());
                    } else if (type.contains("application/")) {        // 应用附件 （zip、xls、docx等）
                        System.out.println("应用文件：" + part.getContent().toString());
                    } else if (type.contains("image/")) {            // 图片附件 （jpg、gpeg、gif等）
                        System.out.println("图片文件：" + part.getContent().toString());
                    }

                    /*****************************************获取邮件内容方法***************************************************/
                    /**
                     * 附件下载
                     * 这里针对image图片类型附件做下载操作，其他类型附件同理
                     */
                    if (type.contains("image/")) {
                        // 打开附件的输入流
                        DataInputStream in = new DataInputStream(part.getInputStream());
                        // 一个文件输出流
                        FileOutputStream out = null;
                        // 获取附件名
                        String fileName = part.getFileName();
                        // 文件名解码
                        fileName = MimeUtility.decodeText(fileName);
                        // 根据附件名创建一个File文件
                        File file = new File("d:/data/" + fileName);
                        // 查看是否有当前文件
                        Boolean b = file.exists();
                        if (!b) {
                            out = new FileOutputStream(file);
                            int data;
                            // 循环读写
                            while ((data = in.read()) != -1) {
                                out.write(data);
                            }
                            System.out.println("附件：【" + fileName + "】下载完毕，保存路径为：" + file.getPath());
                        }

                        // 关流
                        if (in != null) {
                            in.close();
                        }
                        if (out != null) {
                            out.close();
                        }
                    }

                    /**
                     * 获取超文本复合内容
                     * 他本是又是一个Multipart容器
                     * 此时邮件会分为TEXT（纯文本）正文和HTML正文（HTML标签元素）
                     */
                    if (type.equals("multipart/alternative")) {
                        Multipart m = (Multipart) part.getContent();
                        for (int k = 0; k < m.getCount(); k++) {
                            if (m.getBodyPart(k).getContentType().startsWith("text/plain")) {
                                // 处理文本正文
                                System.out.println("TEXT文本内容：" + "\n" + m.getBodyPart(k).getContent().toString().trim() + "\n");
                            } else {
                                // 处理 HTML 正文
                                System.out.println("HTML文本内容：" + "\n" + m.getBodyPart(k).getContent() + "\n");
                            }
                        }
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseMessage(Message[] messages) {
        if (messages == null || messages.length < 1) {
//            throw new MessagingException("未找到要解析的邮件!");
            log.info("not found");
        }
        try {
            // 解析所有邮件
            for (int i = messages.length - 1; i >= messages.length - 3; i--) {
//                if (i==12){
//                    i++;
//                }
                MimeMessage msg = (MimeMessage) messages[i];
                System.out.println("------------------解析第" + msg.getMessageNumber() + "封邮件-------------------- ");
                System.out.println("主题: " + getSubject(msg));
                System.out.println("发件人: " + getFrom(msg));
                System.out.println("收件人：" + getReceiveAddress(msg, null));
                System.out.println("发送时间：" + getSentDate(msg, null));
                System.out.println("是否已读：" + isSeen(msg));
                System.out.println("邮件优先级：" + getPriority(msg));
                System.out.println("是否需要回执：" + isReplySign(msg));
                System.out.println("邮件大小：" + msg.getSize() * 1024 + "kb");
                boolean isContainerAttachment = isContainAttachment(msg);
                System.out.println("是否包含附件：" + isContainerAttachment);
                if (isContainerAttachment) {
                    saveAttachment(msg, "E:\\Ifan\\mail\\" + msg.getSubject().replaceAll("/", "_").replaceAll("：", "_").replaceAll(":", "") + "_"); //保存附件
                }
                StringBuffer content = new StringBuffer(30);
                getMailTextContent(msg, content);
                System.out.println("邮件正文：" + (content.length() > 100 ? content.substring(0, 100) + "..." : content));
                System.out.println("------------------第" + msg.getMessageNumber() + "封邮件解析结束-------------------- ");
                System.out.println();
            }
        } catch (Exception e) {
//            log.info("邮件已被删除！！！-------------------------------DElete");
            log.error("Error", e);
        }

    }

    /**
     * 获得邮件主题
     *
     * @param msg 邮件内容
     * @return 解码后的邮件主题
     */
    public static String getSubject(MimeMessage msg) throws UnsupportedEncodingException, MessagingException {
        return MimeUtility.decodeText(msg.getSubject());
    }

    /**
     * 获得邮件发件人
     *
     * @param msg 邮件内容
     * @return 姓名 <Email地址>
     * @throws MessagingException
     * @throws UnsupportedEncodingException
     */
    public static String getFrom(MimeMessage msg) throws MessagingException, UnsupportedEncodingException {
        String from = "";
        Address[] froms = msg.getFrom();
        if (froms.length < 1) {
            throw new MessagingException("没有发件人!");
        }

        InternetAddress address = (InternetAddress) froms[0];
        String person = address.getPersonal();
        if (person != null) {
            person = MimeUtility.decodeText(person) + " ";
        } else {
            person = "";
        }
        from = person + "<" + address.getAddress() + ">";

        return from;
    }

    /**
     * 根据收件人类型，获取邮件收件人、抄送和密送地址。如果收件人类型为空，则获得所有的收件人
     * <p>Message.RecipientType.TO  收件人</p>
     * <p>Message.RecipientType.CC  抄送</p>
     * <p>Message.RecipientType.BCC 密送</p>
     *
     * @param msg  邮件内容
     * @param type 收件人类型
     * @return 收件人1 <邮件地址1>, 收件人2 <邮件地址2>, ...
     * @throws MessagingException
     */
    public static String getReceiveAddress(MimeMessage msg, Message.RecipientType type) throws MessagingException {
        StringBuffer receiveAddress = new StringBuffer();
        Address[] addresss = null;
        if (type == null) {
            addresss = msg.getAllRecipients();
        } else {
            addresss = msg.getRecipients(type);
        }

        if (addresss == null || addresss.length < 1)
            throw new MessagingException("没有收件人!");
        for (Address address : addresss) {
            InternetAddress internetAddress = (InternetAddress) address;
            receiveAddress.append(internetAddress.toUnicodeString()).append(",");
        }

        receiveAddress.deleteCharAt(receiveAddress.length() - 1); //删除最后一个逗号

        return receiveAddress.toString();
    }

    /**
     * 获得邮件发送时间
     *
     * @param msg 邮件内容
     * @return yyyy年mm月dd日 星期X HH:mm
     * @throws MessagingException
     */
    public static String getSentDate(MimeMessage msg, String pattern) throws MessagingException {
        Date receivedDate = msg.getSentDate();
        if (receivedDate == null)
            return "";

        if (pattern == null || "".equals(pattern))
            pattern = "yyyy年MM月dd日 E HH:mm ";

        return new SimpleDateFormat(pattern).format(receivedDate);
    }

    /**
     * 判断邮件中是否包含附件
     *
     * @param part 邮件内容
     * @return 邮件中存在附件返回true，不存在返回false
     * @throws MessagingException
     * @throws IOException
     */
    public static boolean isContainAttachment(Part part) throws MessagingException, IOException {
        boolean flag = false;
        if (part.isMimeType("multipart/*")) {
            MimeMultipart multipart = (MimeMultipart) part.getContent();
            int partCount = multipart.getCount();
            for (int i = 0; i < partCount; i++) {
                BodyPart bodyPart = multipart.getBodyPart(i);
                String disp = bodyPart.getDisposition();
                if (disp != null && (disp.equalsIgnoreCase(Part.ATTACHMENT) || disp.equalsIgnoreCase(Part.INLINE))) {
                    flag = true;
                } else if (bodyPart.isMimeType("multipart/*")) {
                    flag = isContainAttachment(bodyPart);
                } else {
                    String contentType = bodyPart.getContentType();
                    if (contentType.indexOf("application") != -1) {
                        flag = true;
                    }

                    if (contentType.indexOf("name") != -1) {
                        flag = true;
                    }
                }

                if (flag) {
                    break;
                }
            }
        } else if (part.isMimeType("message/rfc822")) {
            flag = isContainAttachment((Part) part.getContent());
        }
        return flag;
    }

    /**
     * 判断邮件是否已读  www.2cto.com
     *
     * @param msg 邮件内容
     * @return 如果邮件已读返回true, 否则返回false
     * @throws MessagingException
     */
    public static boolean isSeen(MimeMessage msg) throws MessagingException {
        return msg.getFlags().contains(Flags.Flag.SEEN);
    }

    /**
     * 判断邮件是否需要阅读回执
     *
     * @param msg 邮件内容
     * @return 需要回执返回true, 否则返回false
     * @throws MessagingException
     */
    public static boolean isReplySign(MimeMessage msg) throws MessagingException {
        boolean replySign = false;
        String[] headers = msg.getHeader("Disposition-Notification-To");
        if (headers != null)
            replySign = true;
        return replySign;
    }

    /**
     * 获得邮件的优先级
     *
     * @param msg 邮件内容
     * @return 1(High):紧急  3:普通(Normal)  5:低(Low)
     * @throws MessagingException
     */
    public static String getPriority(MimeMessage msg) throws MessagingException {
        String priority = "普通";
        String[] headers = msg.getHeader("X-Priority");
        if (headers != null) {
            String headerPriority = headers[0];
            if (headerPriority.indexOf("1") != -1 || headerPriority.indexOf("High") != -1)
                priority = "紧急";
            else if (headerPriority.indexOf("5") != -1 || headerPriority.indexOf("Low") != -1)
                priority = "低";
            else
                priority = "普通";
        }
        return priority;
    }

    /**
     * 获得邮件文本内容
     *
     * @param part    邮件体
     * @param content 存储邮件文本内容的字符串
     * @throws MessagingException
     * @throws IOException
     */
    public static void getMailTextContent(Part part, StringBuffer content) throws MessagingException, IOException {
        //如果是文本类型的附件，通过getContent方法可以取到文本内容，但这不是我们需要的结果，所以在这里要做判断
        boolean isContainTextAttach = part.getContentType().indexOf("name") > 0;
        if (part.isMimeType("text/*") && !isContainTextAttach) {
            content.append(part.getContent().toString());
        } else if (part.isMimeType("message/rfc822")) {
            getMailTextContent((Part) part.getContent(), content);
        } else if (part.isMimeType("multipart/*")) {
            Multipart multipart = (Multipart) part.getContent();
            int partCount = multipart.getCount();
            for (int i = 0; i < partCount; i++) {
                BodyPart bodyPart = multipart.getBodyPart(i);
                getMailTextContent(bodyPart, content);
            }
        }/*else if (part.isMimeType("application/*")){
            part.getFileName()
        }*/
    }

    /**
     * 保存附件
     *
     * @param part    邮件中多个组合体中的其中一个组合体
     * @param destDir 附件保存目录
     * @throws UnsupportedEncodingException
     * @throws MessagingException
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void saveAttachment(Part part, String destDir) throws UnsupportedEncodingException, MessagingException,
            FileNotFoundException, IOException {
        if (part.isMimeType("multipart/*")) {
            Multipart multipart = (Multipart) part.getContent();    //复杂体邮件
            //复杂体邮件包含多个邮件体
            int partCount = multipart.getCount();
            for (int i = 0; i < partCount; i++) {
                //获得复杂体邮件中其中一个邮件体
                BodyPart bodyPart = multipart.getBodyPart(i);
                //某一个邮件体也有可能是由多个邮件体组成的复杂体
                String disp = bodyPart.getDisposition();
                if (disp != null && (disp.equalsIgnoreCase(Part.ATTACHMENT) || disp.equalsIgnoreCase(Part.INLINE))) {
                    InputStream is = bodyPart.getInputStream();
                    saveFile(is, destDir, decodeText(bodyPart.getFileName()));
                } else if (bodyPart.isMimeType("multipart/*")) {
                    saveAttachment(bodyPart, destDir);
                } else {
                    String contentType = bodyPart.getContentType();
                    if (contentType.indexOf("name") != -1 || contentType.indexOf("application") != -1) {
                        saveFile(bodyPart.getInputStream(), destDir, decodeText(bodyPart.getFileName()));
                    }
                }
            }
        } else if (part.isMimeType("message/rfc822")) {
            saveAttachment((Part) part.getContent(), destDir);
        }
    }

    /**
     * 读取输入流中的数据保存至指定目录
     *
     * @param is       输入流
     * @param fileName 文件名
     * @param destDir  文件存储目录
     * @throws FileNotFoundException
     * @throws IOException
     */
    private static void saveFile(InputStream is, String destDir, String fileName)
            throws FileNotFoundException, IOException {
        BufferedInputStream bis = new BufferedInputStream(is);
        BufferedOutputStream bos = new BufferedOutputStream(
                new FileOutputStream(new File(destDir + fileName)));
        int len = -1;
        while ((len = bis.read()) != -1) {
            bos.write(len);
            bos.flush();
        }
        bos.close();
        bis.close();
    }

    /**
     * 文本解码
     *
     * @param encodeText 解码MimeUtility.encodeText(String text)方法编码后的文本
     * @return 解码后的文本
     * @throws UnsupportedEncodingException
     */
    public static String decodeText(String encodeText) throws UnsupportedEncodingException {
        if (encodeText == null || "".equals(encodeText)) {
            return "";
        } else {
            return MimeUtility.decodeText(encodeText);
        }
    }

    public static void main(String[] args) {
        ReadMailServiceImpl readMailService = new ReadMailServiceImpl();
        readMailService.readMail();

    }
}
