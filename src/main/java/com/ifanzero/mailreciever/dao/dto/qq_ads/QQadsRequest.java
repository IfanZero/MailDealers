
package com.ifanzero.mailreciever.dao.dto.qq_ads;


import java.util.List;

public class QQadsRequest {


    /**
     * data : {"account_id":"123123","order_time":"2017-11-27 00:00:00","url":"http://flzhan.cn/?r_id=123_5d43e36f&_bid=2759&isAdvanced=1","data":[{"label":"姓名","value":"腾讯科技有限公司"},{"label":"电话","value":"0755 8601 3388"},{"label":"省份/城市/行政区","value":"吉林省|白山市|长白朝鲜族自治县"},{"label":"多项选择","value":"多选2|多选3"}]}
     */

    private DataBeanX data;

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX {
        /**
         * account_id : 123123
         * order_time : 2017-11-27 00:00:00
         * url : http://flzhan.cn/?r_id=123_5d43e36f&_bid=2759&isAdvanced=1
         * data : [{"label":"姓名","value":"腾讯科技有限公司"},{"label":"电话","value":"0755 8601 3388"},{"label":"省份/城市/行政区","value":"吉林省|白山市|长白朝鲜族自治县"},{"label":"多项选择","value":"多选2|多选3"}]
         */

        private String account_id;
        private String order_time;
        private String url;
        private List<DataBean> data;

        public String getAccount_id() {
            return account_id;
        }

        public void setAccount_id(String account_id) {
            this.account_id = account_id;
        }

        public String getOrder_time() {
            return order_time;
        }

        public void setOrder_time(String order_time) {
            this.order_time = order_time;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * label : 姓名
             * value : 腾讯科技有限公司
             */

            private String label;
            private String value;

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }
        }
    }
}
