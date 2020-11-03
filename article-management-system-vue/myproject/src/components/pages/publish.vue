<template>
  <div class="publish">
      <el-form :label-position="labelPosition" label-width="80px" :model="formLabelAlign">
        <el-form-item label="文章标题">
            <el-input v-model="formLabelAlign.title"></el-input>
        </el-form-item>
        <el-form-item label="文章类型">
            <el-input v-model="formLabelAlign.type"></el-input>
        </el-form-item>
        <el-form-item label="文章作者">
            <el-input v-model="formLabelAlign.auth"></el-input>
        </el-form-item>
        <el-form-item label="文章内容">
            <el-input rows="15" v-model="formLabelAlign.content" type="textarea" placeholder="请输入内容"></el-input>
        </el-form-item>
        <el-button type="primary" plain @click="publish">提交</el-button>
        </el-form>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  data () {
    return {
        labelPosition: 'left',
        formLabelAlign: {
          title: '',
          type: '',
          auth:'',
          content:''
        }
    }
  },
  methods:{
      publish(){
          var that=this
        if(
            that.formLabelAlign.title==='' || 
            that.formLabelAlign.type==='' || 
            that.formLabelAlign.auth==='' || 
            that.formLabelAlign.content===''
        ){
            that.$message.error('不能为空')
            return false
        }
          axios.post('http://localhost:8090/publish',that.formLabelAlign)
          .then(res=>{
              console.log(res.data)
              if(res.data===true){
                  that.$message({
                      message:'发布成功',
                      type:'success'
                  })
              }else{
                  that.$message.error('发布失败')
              }
          })
      }
  }
}
</script>

<style lang='scss'>
.publish{
    width: 100%;
    height: 100%;
    button{
        width: 26%;
    }
    
}
</style>
