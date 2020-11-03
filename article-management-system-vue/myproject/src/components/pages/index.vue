<template>
	<div class="index">
		<el-container>
		<el-header>文章管理系统</el-header>
		<el-container>
		<el-aside width="200px">
      <el-row class="tac">
        <el-col :span="12" class="col">
          <el-menu
            default-active="2"
            class="el-menu-vertical-demo"
            @open="handleOpen"
            @close="handleClose">
            <el-menu-item index="2" @click="publish">
              <i class="el-icon-menu"></i>
              <span slot="title">发表文章</span>
            </el-menu-item>
            <el-menu-item index="3" @click="queryarticle">
              <i class="el-icon-document"></i>
              <span slot="title">查询文章</span>
            </el-menu-item>
            <el-menu-item index="4">
              <i class="el-icon-setting"></i>
              <span slot="title">回收文章</span>
            </el-menu-item>
          </el-menu>
        </el-col>
      </el-row>
          </el-aside>
          <el-container>
          <el-main class="main">
            <router-view />
          </el-main>
          </el-container>
          </el-container>
          </el-container>
	</div>
</template>
<script>
export default{
	data(){
		return{
			
		}
  },
  methods:{
    publish(){
      this.$router.push('/publish')
    },
    queryarticle(){
      this.$router.push('/queryarticle')
    }
  }
}
</script>

<style lang="scss" scoped>
.index{
  .col{
    width: 100%;
  }
  .main{
    &::-webkit-scrollbar { width: 0 !important }
    -ms-overflow-style: none;
  }
}
	.index,.el-container{
		width:100%;
		height:100%;
	}
  .el-header, .el-footer {
    background-color: #B3C0D1;
    color: #333;
    text-align: center;
    line-height: 60px;
  }
  
  .el-aside {
    background-color: #fff;
    color: #333;
    text-align: center;
    line-height: 200px;
  }
  
  .el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    line-height: 160px;
  }
  
  body > .el-container {
    margin-bottom: 40px;
  }
  
  .el-container:nth-child(5) .el-aside,
  .el-container:nth-child(6) .el-aside {
    line-height: 260px;
  }
  
  .el-container:nth-child(7) .el-aside {
    line-height: 320px;
  }
</style>