<template>
  <div class="hello">
    <el-row :gutter="20">
      <el-col :span="8" :offset="8" id="back">
        <div class="text">登录Admin</div>
        <el-form ref="form" :model="form" label-width="80px" label-position="right" >
          <el-form-item label="用户名">
            <el-input v-model="form.username"></el-input>
          </el-form-item>
          <el-form-item label="密码">
            <el-input type="password" v-model="form.password"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="onSubmit">Login</el-button>
            <el-button>取消</el-button>
            <div class='admin'>
             登录名: admin &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
             密码: admin
            </div>
          </el-form-item>
        </el-form>
      </el-col>
    </el-row>
  </div>
</template>
<script>
import axios from "axios";
axios.defaults.withCredentials = true;
import cookieUtils from "../utils/cookieUtils";
export default {
  name: "HelloWorld",
  // router,
  data() {
    return {
      form: {
        username: "",
        password: ""
      }
    };
  },
  methods: {
    dologin() {
      axios
        .get("/api/doLogin", {
          params: {
            username: "admin",
            password: "admin"
          }
        })
        .then((response) =>{
          console.log(document.cookie);
          console.log(response.data);
          if(cookieUtils.getCookie('admin')){
            this.$store.commit('updateLoginName','admin111111111');
            console.log(this.$store.state.loginName);
          }
          if(response.data.doLogin == 1){
            // self.$router.push('/')
            this.$router.push('/')
            // window.location = "/";
          }
        })
        .catch(function(error) {
          console.log(error);
        });
    },
    onSubmit() {
      this.dologin();
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.hello {
  max-width: 100%;
  height: 650px;
  background: url("../assets/b1.jpg");
  background-size: cover;
  filter: blur(0px);
}

#back {
  /* width: 35%; */
  margin-top: 15%;
  background: #eeeeee;
  border-radius: 10px;
}

.text {
  /* font-family: "Avenir", Helvetica, Arial, sans-serif; */
  font-family: "Helvetica Neue", Helvetica, "PingFang SC", "Hiragino Sans GB",
    "Microsoft YaHei", "微软雅黑", Arial, sans-serif;
  height: 52px;
  font-size: 21px;
  line-height: 52px;
  margin-left: 18px;
  color: #606266;
}
.admin {
  font-size: 14px;
}
</style>
