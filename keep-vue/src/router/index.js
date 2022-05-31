import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'

import Login from '@/views/adminLogin'
import Home from '@/components/Home'
import UserManage from '@/components/user/UserManage'
import CoachManage from '@/components/coach/CoachManage'
import CourseManage from '@/components/course/CourseManage'

Vue.use(Router)

export default new Router({
  mode: 'history',

  routes: [
    {
      path: '/home',
      name: 'Home',
      component: Home,
      redirect: '/hello',
      children: [
        {
          path: '/hello',
          name: 'HelloWorld',
          component: HelloWorld
        },
        {
          path: '/userManage',
          name: 'UserManage',
          component: UserManage
        },
        {
          path: '/coachManage',
          name: 'CoachManage',
          component: CoachManage
        },
        {
          path: '/courseManage',
          name: 'CourseManage',
          component: CourseManage
        }
      ]
    },

    {
      path: '/login',
      name: 'Login',
      component: Login
    }
  ]
})
