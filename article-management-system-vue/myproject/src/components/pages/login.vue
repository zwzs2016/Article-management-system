<template>
  <div class="login">
    <el-container>
      <el-header>登录</el-header>
      <el-main class="loginmain">
           <el-input
            placeholder="请输入用户名"
            prefix-icon="el-icon-user"
            v-model="username">
          </el-input>
          <el-input
            placeholder="请输入密码"
            prefix-icon="el-icon-key"
            v-model="password">
          </el-input>
          <el-button type="primary" @click="login">登录</el-button>
        </el-main>
      </el-container>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  data () {
    return {
      username:'',
      password:''
    }
  },
  methods:{
    login(){
      var that=this;
      if(that.username==='' || that.password===''){
        that.$message.error('不允许为空')
        return false
      }
      axios.post('http://localhost:8090/login',{
        username:that.username,
        password:that.password
      })
      .then(res=>{
        console.log(res.data)
        if(res.data===true){
          that.$message({
            message:'恭喜你,登录成功!',
            type:'success'
          })
          setTimeout('location.href="/"',2000)
        }else{
          that.$message({
            message:'登录失败',
            type:'error'
          })
        }
      })
    }
  }

}
</script>

<style lang="scss">
.login{
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  .el-header{
    line-height: 60px;
  }
  text-align: center;
  section{
    text-align: center;
    .loginmain{
      width: 24rem;
      left: 0;
      right: 0;
      margin: auto;
      input{
        margin: 1rem 0;
      }
      button{
        width: 21rem;
      }
      overflow: hidden;
    }
  }
}
</style>
