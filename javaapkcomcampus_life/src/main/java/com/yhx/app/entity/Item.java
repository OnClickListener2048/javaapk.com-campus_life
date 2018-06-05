package com.yhx.app.entity;

import java.util.List;

public class Item {

    /**
     * pageCount : 1
     * data : [{"put_time":1527224688000,"school":"mdlakdsadsa","price":"131.00元","userPhone":"13114917491","shopname":"dsadsad","description":"32131312321","shopId":1,"userName":"wangxue","category":"行业培训类","picture":""}]
     * pageNo : 1
     * recordCount : 2
     * pageSize : 10
     */

    private int pageCount;
    private int pageNo;
    private int recordCount;
    private int pageSize;
    private List<DataBean> data;

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * put_time : 1527224688000
         * school : mdlakdsadsa
         * price : 131.00元
         * userPhone : 13114917491
         * shopname : dsadsad
         * description : 32131312321
         * shopId : 1
         * userName : wangxue
         * category : 行业培训类
         * picture :
         */

        private long put_time;
        private String school;
        private String price;
        private String userPhone;
        private String shopname;
        private String description;
        private int shopId;
        private String userName;
        private String category;
        private String picture;

        public long getPut_time() {
            return put_time;
        }

        public void setPut_time(long put_time) {
            this.put_time = put_time;
        }

        public String getSchool() {
            return school;
        }

        public void setSchool(String school) {
            this.school = school;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getUserPhone() {
            return userPhone;
        }

        public void setUserPhone(String userPhone) {
            this.userPhone = userPhone;
        }

        public String getShopname() {
            return shopname;
        }

        public void setShopname(String shopname) {
            this.shopname = shopname;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getShopId() {
            return shopId;
        }

        public void setShopId(int shopId) {
            this.shopId = shopId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }
    }
}
