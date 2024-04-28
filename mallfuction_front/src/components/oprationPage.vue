<script setup>
</script>

<template>

  <el-card style="width: 40%">

    <template #header>
      <h2 style="color: #f56c6c"><slot name="head"></slot></h2>
    </template>

    <div>
      <slot name="middle"></slot>
    </div>

    <template #footer>
      <el-row :gutter="20">
        <el-col :span="12">
            <slot name="left"></slot>
        </el-col>
        <el-col :span="12" style="text-align: right">
            <slot name="right"></slot>
        </el-col>
      </el-row>
    </template>
  </el-card>
</template>

<style scoped>

</style>