<script setup>
import {Search,House,User} from '@element-plus/icons-vue'
</script>

<template>
  <div style="text-align: center;height: 100vh;overflow: hidden;background-color: white">
    <div style="background-color: white;padding: 20px">
      <h1 style="font-size: 30px;color: #52467f">商品后台系统</h1>
    </div>

    <el-divider></el-divider>

    <div class="asideMenu">
      <el-scrollbar height="100%">
      <el-menu :router="true">
        <el-menu-item index="/">
          <el-icon><house></house></el-icon>
          <span>首页</span>
        </el-menu-item>

        <el-menu-item index="/search">
            <span>商品管理</span>
        </el-menu-item>

        <el-sub-menu index="1">
          <template #title><span>用户管理</span></template>
          <el-menu-item>添加用户</el-menu-item>
        </el-sub-menu>
      </el-menu>
      </el-scrollbar>
    </div>
  </div>
</template>

<style scoped>
  .asideMenu{
    padding: 20px;
    height: 100%;
  }

  .asideMenu el-menu-item{
    border-radius: 8px;
  }

  .asideMenu span{
    font-size: 20px;
  }



  .el-menu-item{
    border-radius: 8px;
  }
</style>