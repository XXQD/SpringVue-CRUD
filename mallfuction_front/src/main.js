import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'
import router from './router'
import 'element-plus/dist/index.css'

import axios from "axios";

const app = createApp(App)

app.use(createPinia())
app.use(router)

axios.defaults.baseURL = 'http://localhost:8080'

app.mount('#app')
