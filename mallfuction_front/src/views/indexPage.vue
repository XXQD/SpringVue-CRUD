<script setup>
import '../components/navCom.vue'
import NavCom from "@/components/navCom.vue";
import AsidePage from '@/components/asidePage.vue'
</script>

<template>
  <el-container>
    <el-aside style="z-index: 1;width: 280px; height: 100vh;box-shadow: 2px 0px grey;border-radius: 2px"><aside-page></aside-page></el-aside>

    <el-container>

      <el-header style="margin-top: 10px;"><nav-com></nav-com></el-header>

      <el-main style="background-color: #eef4fa;overflow: hidden;height: 100%">

        <router-view v-slot="{ Component }">
          <transition name="el-fade-in-linear">
            <component :is="Component"/>
          </transition>
        </router-view>

      </el-main>
    </el-container>
  </el-container>

</template>

<style scoped>

</style>