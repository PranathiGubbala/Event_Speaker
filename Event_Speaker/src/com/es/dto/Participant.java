package com.es.dto;

public class Participant {
        private String name;
        private String mobile;
        private String college;
        private int id;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getMobile() {
            return mobile;
        }
        public void setMobile(String mobile) {
            this.mobile = mobile;
        }
        public String getCollege() {
            return college;
        }
        public void setCollege(String college) {
            this.college = college;
        }
        public int getId() {
            return id;
        }
        public void setId(int id ) {
            this.id = id;
        }
       
        public String toString() {
            return "Participant [ Id=" + id + ", Name=" + name + ", mobile=" + mobile + ", college="+ college +"]";
        }
}



