import axios from 'axios'
import {ElMessage} from "element-plus";

const defaultFailure = () => {ElMessage.warning(data)}
const defaultError = () => {ElMessage.error('系统异常')}
function post(url,data,success,failure = defaultFailure,error = defaultError){
    axios.post(url,data,{
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        withCredentials: true
    }).then(({data}) => {
        if(data.success){
            success(data.data,data.status)
        }else{
            failure(data.data,data.status)
        }
    }).catch(error)
}

function get(url,success,failure = defaultFailure,error = defaultError){
    axios.get(url,{
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        withCredentials: true
    }).then(({data}) => {
        if(data.success){
            success(data.data,data.status)
        }else{
            failure(data.data,data.status)
        }
    }).catch(error)
}

function put(url,data,success,failure = defaultFailure,error = defaultError){
    axios.put(url,data,{
        headers: {
            'Content-Type': 'application/json'
        },
        withCredentials: true
    }).then(({data}) => {
        if(data.success){
            success(data.data,data.status)
        }else{
            failure(data.data,data.status)
        }
    }).catch(error)
}

export {post,get,put}