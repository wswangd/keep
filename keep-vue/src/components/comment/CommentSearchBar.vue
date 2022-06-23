<template>
    <div>
        <el-input
        placeholder="请输入课程编号"
        v-model="input"
        clearable
        style="width: 400px; margin-right: 10px">
        </el-input>
        <el-button type="primary" icon="el-icon-search" @click="searchClick">搜索</el-button>
    </div>
</template>

<script>
  export default {
    name: 'CommentSearchBar',
    data() {
      return {
        input: ''
      }
    },

    methods: {
      searchClick () {
        this.$emit('onSearch')
      },
    }
  }
</script>