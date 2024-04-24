<script setup>
import {post,get} from '../net/index.js'
import {ElMessage} from "element-plus";
import {ref,computed } from 'vue'
import {Search} from '@element-plus/icons-vue'
import OprationPage from '../components/oprationPage.vue'

//初始化
const shopList = ref([])
//刷新数据
const sendMessage = () => {
  get('/goods/search',(data) => {
    shopList.value = data
  })
}
//进入页面刷新获取表格信息
sendMessage()
//子组件调用父组件刷新功能
const reFreshTable = () => {
  sendMessage()
}
//显示小组件
const isEditVisible = ref(false)

const getMessage = (mes) => {
  isEditVisible.value = mes
  isAddVisible.value = mes
}
//定义参数 获取当前表格行的参数值
const formInfo = ref({
  id: 0,
  name: '',
  amount: ''
})

function handleButtonClick(row){
  isEditVisible.value = true;
  formInfo.value.id = row.id
  formInfo.value.name = row.name
  formInfo.value.amount = row.amount
}
//添加元素
const isAddVisible = ref(false)
const addColumn = () => {
  isAddVisible.value = true
}
</script>

<template>
  <div style="margin-bottom: 20px">
    <el-row>
      <el-col :span="12">
        <el-input placeholder="搜索物品...">
          <template #suffix>
            <el-link :underline="false">
                <el-icon>
                  <Search></Search>
                </el-icon>
            </el-link>
          </template>

        </el-input>
      </el-col>
      <el-col :span="12" style="text-align: right">
        <el-button @click="sendMessage">刷新</el-button>
        <el-button type="success" @click="addColumn">添加</el-button>
      </el-col>
    </el-row>
  </div>
  <div>
    <el-table :data="shopList" :stripe="true" :border="true">
      <el-table-column  label="编号" type="index">
      </el-table-column>
      <el-table-column prop="name" label="商品名称"></el-table-column>
      <el-table-column prop="amount" label="商品数量"></el-table-column>
      <el-table-column label="操作商品">
        <template #default="scope">
          <el-button type="primary" @click="handleButtonClick(scope.row)">修改</el-button>
          <el-button type="danger">删除</el-button>
        </template>


      </el-table-column>
    </el-table>
  </div>

  <template>
    <el-pagination background layout="prev, pager, next" :total="1000" />
  </template>

  <div style="position: fixed;top: 50%;left: 50%;width: 50%;z-index: 100">
        <opration-page v-if="isEditVisible" :formMes="formInfo" :isEditVisible="isEditVisible" @modifyIsEditVisible="getMessage" @refresh="reFreshTable">
          <template #head>
            修改商品
          </template>
          <template #left>
            立即修改
          </template>
          <template #right>
            取消修改
          </template>
        </opration-page>
  </div>

  <div style="position: fixed;top: 50%;left: 50%;width: 50%;z-index: 100">
        <opration-page v-if="isAddVisible" :isAddVisible="isAddVisible">
          <template #head>
            增加商品
          </template>
          <template #left>
            立即添加
          </template>
          <template #right>取消添加</template>
        </opration-page>
  </div>




</template>



<style scoped>

</style>