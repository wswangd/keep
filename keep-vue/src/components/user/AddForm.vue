<template>
  <el-dialog 
  title="增加用户" 
  :visible.sync="dialogFormVisible2"
  @close="clear">
    <el-form :model="form">
      <el-form-item label="用户名" :label-width="formLabelWidth">
        <el-input v-model="form.username" auto-complete="off"></el-input>
      </el-form-item>
      <el-form-item label="密码" :label-width="formLabelWidth">
        <el-input v-model="form.password" auto-complete="off"></el-input>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="dialogFormVisible2 = false">取消</el-button>
      <el-button type="primary" @click="AddUser">确定</el-button>
    </div>
  </el-dialog>
</template>

<script>
  export default {
    name: 'AddForm',
    data () {
      return {
        dialogFormVisible2: false,
        form: {
          username: '',
          password: ''
        },
        formLabelWidth: '120px'
      }
    },

    methods: {
      clear () {
        this.form = {
          username: '',
          password: ''
        }
      },

      AddUser () {
        this.$axios
        .post('/user', {
          username: this.form.username,
          password: this.form.password
        })
        .then(response => {
          if (response.status === 200) {
            this.dialogFormVisible2 = false
            this.$emit('onAdd')
          }
        })
      }
    }
  }
</script>