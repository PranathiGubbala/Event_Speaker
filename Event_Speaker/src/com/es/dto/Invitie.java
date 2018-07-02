package com.es.dto;

public class Invitie {
        private String emailId;
        private String status;
        private Participant pId;
        public String getEmailId() {
            return emailId;
        }
        public void setEmailId(String emailId) {
            this.emailId = emailId;
        }
        public String getStatus() {
            return status;
        }
        public void setStatus(String status) {
            this.status = status;
        }
        public Participant getPId() {
            return pId;
        }
        public void setPId(Participant pId) {
            this.pId = pId;
        }
        public String toString() {
            return "Invitie [emailId=" + emailId +", status=" + status + ", pId=" + pId + "]";
        }
    }




