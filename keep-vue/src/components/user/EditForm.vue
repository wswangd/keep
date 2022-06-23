<template>
  <el-dialog 
  title="修改用户" 
  :visible.sync="dialogFormVisible"
  @close="clear">
    <el-form :model="form">
      <el-form-item label="Id" :label-width="formLabelWidth">
        <span>{{form.id}}</span>
      </el-form-item>
      <el-form-item label="用户名" :label-width="formLabelWidth">
        <el-input v-model="form.username" auto-complete="off"></el-input>
      </el-form-item>
      <el-form-item label="密码" :label-width="formLabelWidth">
        <el-input v-model="form.password" auto-complete="off"></el-input>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="dialogFormVisible = false">取消</el-button>
      <el-button type="primary" @click="updateUser">确定</el-button>
    </div>
  </el-dialog>
</template>

<script>
  export default {
    name: 'EditForm',
    data () {
      return {
        dialogFormVisible: false,
        form: {
          id: '',
          username: '',
          password: ''
        },
        formLabelWidth: '120px'
      }
    },

    methods: {
      clear () {
        this.form = {
          id: '',
          username: '',
          password: ''
        }
      },

      updateUser () {
        this.$axios
        .put('/user', {
          id: this.form.id,
          username: this.form.username,
          password: this.form.password
        })
        .then(response => {
          if (response.status === 200) {
            this.dialogFormVisible = false
            this.$emit('onSubmit')
          }
        })
      }
    }
  }
</script>