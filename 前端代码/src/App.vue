<template>
  <div id="app" class="bc">
    <div>
      <vue-particles
        color="#dedede"
        :particleOpacity="0.7"
        :particlesNumber="40"
        shapeType="star"
        :particleSize="4"
        linesColor="#FFFFFF"
        :linesWidth="2"
        :lineLinked="true"
        :lineOpacity="0.4"
        :linesDistance="150"
        :moveSpeed="3"
        :hoverEffect="true"
        hoverMode="grab"
        :clickEffect="true"
        clickMode="push"
        class="cash"
      >
      </vue-particles>
    </div>
    <div>
    <el-container>
      <el-header style="text-align: center;background-color:  transparent; font-size: 20px;position: relative">图书管理系统</el-header>
    </el-container>
    <el-container style="height: 700px; border: 0px solid #eee">
      <el-aside width="200px" style="background-color:  transparent">
        <el-menu  style="background-color:  transparent" :default-openeds="open_list" router>
          <el-submenu index="1">
            <template slot="title"><i class="el-icon-menu"></i>图书管理</template>
              <el-menu-item index="/bookList">图书列表</el-menu-item>
              <el-menu-item index="/addBook">添加图书</el-menu-item>
              <el-menu-item index="/searchBook">检索图书</el-menu-item>
          </el-submenu>
          <el-submenu index="2">
            <template slot="title"><i class="el-icon-menu"></i>用户管理</template>
              <el-menu-item index="accountList">用户列表</el-menu-item>
            <el-menu-item index="addAccount">添加用户</el-menu-item>
            <el-menu-item index="salePersonList">销售人员列表</el-menu-item>
            <el-menu-item index="addSalePerson">添加销售人员</el-menu-item>
            </el-submenu>
          <el-submenu index="3">
            <template slot="title"><i class="el-icon-menu"></i>销售管理</template>
              <el-menu-item index="salesRecord">销售记录</el-menu-item>
            <el-menu-item index="addSaleRecord">添加记录</el-menu-item>
            <el-menu-item index="recordAnalysis">数据分析</el-menu-item>
          </el-submenu>
        </el-menu>
      </el-aside>
      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
    </div>
  </div>
</template>

<style>
.el-header {
  background-color: #B3C0D1;
  color: #333;
  line-height: 60px;
}

.el-aside {
  color: #333;
}
.cash {
  position:fixed;
  top:5px;
  width:100%;
  /*background-image: url("assets/backgroud.jpg");*/
}
.bc{
  background-image: url("assets/backgroud.jpg");
  height: 100%;
}
/*.el-menu-item{*/
/*  color: #eeeeee;*/
/*  background-color: #2279e8;*/
/*}*/
.el-submenu__title{
  color: #eeeeee;
}
.el-header{
  color: #eeeeee;
}
</style>

<script>
export default {

}
</script>
