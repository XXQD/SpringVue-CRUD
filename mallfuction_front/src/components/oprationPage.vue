<script setup>
import {ref} from 'vue'
import {post, put} from "@/net/index.js";
import {ElMessage} from "element-plus";
//定义接收参数
  const props = defineProps({
    isEditVisible: {
      type: Boolean,
      default: false
    },
    isAddVisible: {
      type: Boolean,
      default: false
    },
    formMes: {
      type: Object,
      default: {}
    }
  })
//定义父组件响应自定义事件名
  const emit = defineEmits(['modifyIsEditVisible','refresh'])
//触发父组件事件方法
  const concleFuction = () => {
    emit('modifyIsEditVisible',false)
  }
//接受参数
  const sonFormMes = ref({
    id: props.formMes.id,
    name: props.formMes.name,
    amount: props.formMes.amount
  })

  const sonrefreshTable = () => {
    emit('refresh')
  }
  const modify = () => {
    put('/goods/update',{
      ...sonFormMes.value
    },() => {
      ElMessage.warning('修改成功')
      concleFuction()
      sonrefreshTable()
    })
  }

</script>

<template>
  <el-card style="width: 40%">
    <template #header>
      <h2 style="color: #f56c6c"><slot name="head"></slot></h2>
    </template>

    <div>
      <el-input placeholder="商品名称" v-model="sonFormMes.name">
        这个编辑栏的信息是指定好的还是自定义提供的
      </el-input>

      <el-input placeholder="商品数量" v-model="sonFormMes.amount">

      </el-input>
    </div>

    <template #footer>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-button type="success" style="width: 100%" @click="modify">
            <slot name="left"></slot>
          </el-button>
        </el-col>
        <el-col :span="12" style="text-align: right">
          <el-button type="danger" style="width: 100%" @click="concleFuction">
            <slot name="right"></slot>
          </el-button>
        </el-col>
      </el-row>
    </template>
  </el-card>

  <slot></slot>
</template>

<style scoped>

</style>