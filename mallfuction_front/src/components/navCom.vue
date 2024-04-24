<script setup>
  import {Search,Setting,User,Moon,Bell} from '@element-plus/icons-vue'
  import 'element-plus/theme-chalk/display.css'
</script>

<template>
  <div>
    <el-row :justify="'space-between'" :align="'middle'" style="text-align: center">

      <el-col :span=10>
          <el-input :size="'large'"  placeholder="搜索..." style="padding: 10px">
            <template #suffix>
              <el-link :underline="false">
                <el-icon><Search></Search></el-icon>
              </el-link></template>
          </el-input>
      </el-col>

      <el-col :span=8>
        <el-row :justify="'center'" :align="'middle'" class="rightNav">
          <el-col :span="3">
            <el-link :underline="false">
              <el-icon ><User></User></el-icon>
            </el-link>
          </el-col>

          <el-col :span="4">
            <el-link :underline="false">
              <template #icon>
                <el-icon><Setting></Setting></el-icon>
              </template>
            </el-link>
          </el-col>

          <el-col :span="4">
            <el-link :underline="false">
              <el-icon ><Moon></Moon></el-icon>
            </el-link>
          </el-col>

          <el-col :span="4">
            <el-link :underline="false">
              <el-icon ><Bell></Bell></el-icon>
            </el-link>
          </el-col>

          <el-col :span="4">
            <el-link :underline="false">
              <span>图片</span>
            </el-link>
          </el-col>


        </el-row>
      </el-col>
    </el-row>
  </div>
</template>

<style scoped>
  .rightNav .el-link--default {
    border: solid 2px;
    border-radius: 50%;
    height: 30px;
    width: 30px;
  }
</style>