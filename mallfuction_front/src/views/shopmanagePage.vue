<script setup>
import {post,get} from '../net/index.js'
import {ElMessage} from "element-plus";
import {ref,computed } from 'vue'
import {Search} from '@element-plus/icons-vue'

const shopList = ref([])
const sendMessage = () => {
  get('/goods/search',(data) => {
    shopList.value = data
  })
}
const shopListIndex = computed(() => {
  return shopList.value = shopList.value.map((item, index) => ({
    ...item,
    index: index + 1 // 索引从0开始，所以+1来得到从1开始的序号
  }));
})

sendMessage()
</script>

<template>
  <div style="margin-bottom: 20px">
    <el-row>
      <el-col :span="12">
        <el-input placeholder="搜索物品">
          <template #suffix>
            <el-link :underline="false">
                <el-icon>
                  <Search></Search>
                </el-icon>
            </el-link>
          </template>

        </el-input>
      </el-col>
      <el-col :span="4"></el-col>
      <el-col :span="8">
        <el-button @click="sendMessage">刷新</el-button>
      </el-col>
    </el-row>
  </div>
  <div>
    <el-table :data="shopList">
      <el-table-column prop="shopListIndex" label="序列号"></el-table-column>
      <el-table-column prop="name" label="姓名"></el-table-column>
      <el-table-column prop="amount" label="数量"></el-table-column>
      <el-table-column label="操作" >
        <el-button type="primary">修改</el-button>
        <el-button type="danger">删除</el-button>
      </el-table-column>
    </el-table>
  </div>

  <template>
    <el-pagination background layout="prev, pager, next" :total="1000" />
  </template>
</template>

<style scoped>

</style>