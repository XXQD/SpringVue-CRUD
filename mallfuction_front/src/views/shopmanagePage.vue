<script setup>
import {post, get, put,deleted} from '../net/index.js'
import {ElMessage} from "element-plus";
import {ref,computed,watch } from 'vue'
import {Search} from '@element-plus/icons-vue'
import OprationPage from '../components/oprationPage.vue'

//初始化数据
const shopList = ref([])
//刷新数据
const sendMessage = () => {
  get('/goods/search',(data) => {
    shopList.value = data
    isEditVisible.value = false
    isDeleteVisible.value = false
    isAddVisible.value = false
    searchName.value = ''
    searchByName.value.length = 0 //状态问题？？？能实现功能就行
  })
}
//进入页面刷新获取表格信息
sendMessage()

//定义参数 获取当前表格行的参数值
const formInfo = ref({
  id: 0,
  name: '',
  amount: ''
})

//组件显示属性
const isEditVisible = ref(false)
const exhibitData = ref()
//获取当前行的信息
function handleButtonClick(row){
  isAddVisible.value = false
  isDeleteVisible.value = false
  isEditVisible.value = !isEditVisible.value
  formInfo.value.id = row.id
  formInfo.value.name = row.name
  formInfo.value.amount = row.amount
  exhibitData.value = row.name
}
//修改方法
const modify = () => {
  put('/goods/update',{
    ...formInfo.value
  },() => {
    ElMessage.warning('修改成功')
    isEditVisible.value = false
    if(searchByName.value.length > 0){
      searchFunction()
    }else{
      sendMessage()
    }
  })
}
//添加方法
const isAddVisible = ref(false)
const addButton = () => {
  isEditVisible.value =false
  isDeleteVisible.value = false
  isAddVisible.value = !isAddVisible.value
  formInfo.value.name = ''
  formInfo.value.amount = ''
}
const addFuction = () => {
  post('goods/add',{
    ...formInfo.value,
  },() => {
    ElMessage.warning('添加成功')
    isAddVisible.value = false
    if(searchByName.value.length > 0){
      searchFunction()
    }else{
      sendMessage()
    }
  })
}

//删除功能
const isDeleteVisible = ref(false)

const deleteButton = (row) => {
  isEditVisible.value = false
  isAddVisible.value = false
  isDeleteVisible.value = !isDeleteVisible.value
  formInfo.value.id = row.id
}

const deleteFunction = () => {
  const id = formInfo.value.id
  const url = `/goods/delete/${id}`
  deleted(
      url, (data) => {
        ElMessage.warning('删除成功')
        isDeleteVisible.value = false
        if(searchByName.value.length > 0){
          searchFunction()
        }else{
          sendMessage()
        }
      }
  )
}

//按名称查询
const searchName = ref()
const searchByName = ref([])
const searchFunction = () => {
  if(searchName.value === ''){
    ElMessage.error('查询名称不能为空')
    return
  }else{
    const url = `/goods/searchByName/${searchName.value}`
    get(url,(data) => {
      console.log(data)
      if(data.length === 0){
        ElMessage.warning('没有查到数据')
      }else{
        shopList.value = data
        searchByName.value = data
      }
    })
  }
}
  // watch(byNameList.value,(newValue,oldValue) => {
  //   searchFunction()
  // })

</script>

<template>
  <div style="margin-bottom: 20px">
    <el-row>
      <el-col :span="12">
        <el-input placeholder="搜索物品..." v-model="searchName">
          <template #suffix>
            <el-link :underline="false" @click="searchFunction">
                <el-icon>
                  <Search></Search>
                </el-icon>
            </el-link>
          </template>

        </el-input>
      </el-col>
      <el-col :span="12" style="text-align: right">
        <el-button @click="sendMessage">刷新</el-button>
        <el-button type="success" @click="addButton">添加</el-button>
      </el-col>
    </el-row>
  </div>

  <div>
    <el-table :data="shopList" :stripe="true" :border="true">
      <el-table-column  label="编号" type="index">
      </el-table-column>
      <el-table-column prop="name" label="商品名称" ></el-table-column>
      <el-table-column prop="amount" label="商品数量"></el-table-column>
      <el-table-column label="操作商品">
        <template #default="scope">
          <el-button type="primary" @click="handleButtonClick(scope.row)">修改</el-button>
          <el-button type="danger" @click="deleteButton(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
<!--  分页-->
  <div style="margin:0 auto">
    <el-pagination background layout="prev, pager, next" :total="1000"/>
  </div>
<!--修改功能-->
  <div style="position: fixed;top: 50%;left: 50%;width: 50%;z-index: 100">
        <opration-page v-if="isEditVisible">
          <template #head>
            修改{{ exhibitData }}
          </template>
          <template #middle>
            <el-input placeholder="商品名称" v-model="formInfo.name" style="padding-bottom: 10px"></el-input>
            <el-input placeholder="商品数量" v-model="formInfo.amount"></el-input>
          </template>
          <template #left>
            <el-button @click="modify" type="success" style="width: 100%">立即修改</el-button>
          </template>
          <template #right>
            <el-button @click="isEditVisible = false" type="danger" style="width: 100%">取消修改</el-button>
          </template>
        </opration-page>
  </div>
<!--增加功能-->
  <div style="position: fixed;top: 50%;left: 50%;width: 50%;z-index: 100">
        <opration-page v-if="isAddVisible">
          <template #head>
            增加商品
          </template>
          <template #middle>
            <el-input placeholder="商品名称" v-model="formInfo.name" style="padding-bottom: 10px">
            </el-input>
            <el-input placeholder="商品数量" v-model="formInfo.amount">
              添加商品
            </el-input>
          </template>
          <template #left>
            <el-button @click="addFuction" type="success" style="width: 100%">立即添加</el-button>
          </template>
          <template #right>
            <el-button @click="isAddVisible = false" type="danger" style="width: 100%">取消添加</el-button>
          </template>
        </opration-page>
  </div>

  <div style="position: fixed;top: 50%;left: 50%;width: 50%;z-index: 100">
    <opration-page v-if="isDeleteVisible">
      <template #head>
        <h2>确定要删除吗?</h2>
      </template>
      <template #middle>
        真的考虑清楚了???
      </template>
      <template #left>
        <el-button type="success" style="width: 100%" @click="deleteFunction">确定删除</el-button>
      </template>
      <template #right>
        <el-button  type="danger" style="width: 100%" @click="isDeleteVisible = false">点错了</el-button >
      </template>
    </opration-page>
  </div>

<!--  <div>-->
<!--    <el-table :data="middleList" :stripe="true" :border="true">-->
<!--      <el-table-column  label="编号" type="index"></el-table-column>-->
<!--      <el-table-column prop="name" label="商品名称" ></el-table-column>-->
<!--      <el-table-column prop="amount" label="商品数量"></el-table-column>-->
<!--      <el-table-column label="操作商品">-->
<!--        <template #default="scope">-->
<!--          <el-button type="primary" @click="handleButtonClick(scope.row);">修改</el-button>-->
<!--          <el-button type="danger" @click="deleteButton(scope.row)">删除</el-button>-->
<!--        </template>-->
<!--      </el-table-column>-->
<!--    </el-table>-->
<!--  </div>-->

</template>

<style scoped>

</style>