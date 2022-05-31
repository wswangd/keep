<template>
    <el-menu
      :default-active="'/hello'"
      router
      mode="horizontal"
      background-color="white"
      text-color="#222"
      active-text-color="red"
      style="min-width: 1300px">
      <el-menu-item v-for="(item,i) in navList" :key="i" :index="item.name">
        {{ item.navItem }}
      </el-menu-item>
    </el-menu>
</template>

<script>
  export default {
    name: 'NavMenu',
    data () {
      return {
        navList: [
          {name: '/hello', navItem: '首页'},
          {name: '/userManage', navItem: '用户管理'},
          {name: '/coachManage', navItem: '教练管理'},
          {name: '/courseManage', navItem: '课程管理'},
          {name: '/orderManage', navItem: '订单管理'}
        ]
      }
    }
  }
</script>

<style scoped>
</style>