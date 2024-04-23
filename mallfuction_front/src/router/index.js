import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'index',
      component: () =>  import('@/views/indexPage.vue'),
      children:[
        {
          path: '/',
          name: 'home',
          component: () => import('@/views/homePage.vue')
        },
        {
          path: '/search',
          name: 'search',
          component: () => import('@/views/shopmanagePage.vue')
        }
      ]
    },
    {

    }
  ]
})

export default router
