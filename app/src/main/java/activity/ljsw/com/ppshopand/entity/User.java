package activity.ljsw.com.ppshopand.entity;

import activity.ljsw.com.ppshopand.entity.msg.BaseRespMsg;

/**
 * Created by lianchao on 2018/12/5.
 */

public class User  extends BaseRespMsg {
        private String email;
        private String logo_url;
        private String username;
        private String mobi;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getLogo_url() {
            return logo_url;
        }

        public void setLogo_url(String logo_url) {
            this.logo_url = logo_url;
        }

        public String getMobi() {
            return mobi;
        }

        public void setMobi(String mobi) {
            this.mobi = mobi;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
}
