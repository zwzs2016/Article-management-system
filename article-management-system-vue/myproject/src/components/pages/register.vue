<template>
  <div class="register">
    <el-container>
        <el-header>注册</el-header>
        <el-main class="registermain">
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
          <el-button type="primary" @click="register">注册</el-button>
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
    register(){
      var that=this;
      if(that.username==='' || that.password===''){
        that.$message.error('不允许为空')
        return false
      }
      axios.post('http://localhost:8090/register',{
        username:that.username,
        password:that.password
      })
      .then(res=>{
        console.log(res.data)
        if(res.data===true){
          that.$message({
            message:'恭喜你,注册成功!',
            type:'success'
          })
          setTimeout('location.href="/login"',2000)
        }else{
          that.$message({
            message:'注册失败',
            type:'error'
          })
        }
      })
      
    }
  }
}
</script>

<style lang="scss">
.register{
  // margin: 1rem 0;
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
    .registermain{
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
