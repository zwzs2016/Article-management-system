<template>
  <div class="queryarticle">
      <div class="search" style="margin-top: 15px; height:5rem">
        <el-input placeholder="请输入内容" v-model="input3" class="input-with-select">
            <el-select v-model="select" slot="prepend" placeholder="请选择">
            <el-option label="标题" value="title"></el-option>
            <el-option label="作者" value="auth"></el-option>
            <el-option label="发表日期" value="createtime"></el-option>
            </el-select>
            <el-button slot="append" icon="el-icon-search" @click="search"></el-button>
        </el-input>
       </div>
    <el-table
    :data="tableData"
    border
    style="width: 100%"
    height="550"
    >
        <el-table-column
        prop="title"
        label="标题"
        width="180" height="100">
        </el-table-column>
        <el-table-column
        prop="type"
        label="类型"
        width="180">
        </el-table-column>
        <el-table-column
        prop="content"
        label="内容">
        </el-table-column>
        <el-table-column
        prop="auth"
        label="作者">
        </el-table-column>
        <el-table-column
        prop="createtime"
        label="发表时间">
        </el-table-column>
        <el-table-column label="操作">
      <template slot-scope="scope">
        <el-button
          size="mini"
          @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
        <el-button
          size="mini"
          type="danger"
          @click="handleDelete(scope.$index, scope.row)">删除</el-button>
      </template>
    </el-table-column>
    </el-table>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  data () {
    return {
        input1: '',
        input2: '',
        input3: '',
        select: '',
        tableData: []
    }
  },
  created(){
      var that=this
      // if(localStorage.getItem('selectall')){
      //   let selectall=localStorage.getItem('selectall')
      //   console.log(JSON.parse(selectall))
      //   that.tableData=JSON.parse(selectall)
      //   console.log(that.tableData)
      //   return false
      // }
      console.log('create')
      axios.get('http://localhost:8090/selectall')
      .then(res=>{
          console.log(res.data)
          that.tableData=res.data.vaules
          localStorage.setItem('selectall',JSON.stringify(res.data.vaules))
      })
      
  },
  methods:{
    search(){
      var that=this
      var text='http://localhost:8090/search?'+that.select+'='+that.input3
      console.log(text)
      if(that.search===null){
        that.$message.error('不能为空')
        return false
      }
      axios.get('http://localhost:8090/search?'+that.select+'='+that.input3)
      .then(res=>{
        console.log(res.data)
        that.tableData=res.data.values
        console.log(that.tableData)
      })
    }
  }
}
</script>

<style lang='scss'>
.queryarticle{
    width: 100%;
    height: 100%;
    &::-webkit-scrollbar { width: 0 !important }
    -ms-overflow-style: none;
    .el-table{
        width: 100%;
        height: 100%;
        &:hover{
            cursor: pointer;
        }
    }
    .el-select .el-input {
    width: 130px;
    }
    .input-with-select .el-input-group__prepend {
        background-color: #fff;
    }
    .search{
        display: flex;
        justify-content: center;
        align-items: center;
    }
}
</style>
