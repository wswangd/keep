<template>
  <el-dialog 
  title="修改课程" 
  :visible.sync="dialogFormVisible"
  @close="clear">
    <el-form :model="form">
      <el-form-item label="Id" :label-width="formLabelWidth">
        <span v-model="form.id">{{form.id}}</span>
      </el-form-item>
      <el-form-item label="课程名" :label-width="formLabelWidth">
        <el-input v-model="form.name" auto-complete="off"></el-input>
      </el-form-item>
      <el-form-item label="教练Id" :label-width="formLabelWidth">
        <el-input v-model="form.coach_id" auto-complete="off"></el-input>
      </el-form-item>
      <el-form-item label="教练名" :label-width="formLabelWidth">
        <el-input v-model="form.coach" auto-complete="off"></el-input>
      </el-form-item>
      <el-form-item label="课时" :label-width="formLabelWidth">
        <el-input v-model="form.classes" auto-complete="off"></el-input>
      </el-form-item>
      <el-form-item label="课程介绍" :label-width="formLabelWidth">
        <el-input v-model="form.introduction" auto-complete="off"></el-input>
      </el-form-item>
      <el-form-item label="价格" :label-width="formLabelWidth">
        <el-input v-model="form.price" auto-complete="off"></el-input>
      </el-form-item>
      <el-form-item label="图片" :label-width="formLabelWidth">
        <el-input v-model="form.picture" auto-complete="off"></el-input>
        <!-- <img-upload @onUpload="uploadImg" ref="imgUpload"></img-upload> -->
      </el-form-item>
      <el-form-item label="视频" :label-width="formLabelWidth">
        <el-input v-model="form.video" auto-complete="off"></el-input>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="dialogFormVisible = false">取消</el-button>
      <el-button type="primary" @click="updateCourse">确定</el-button>
    </div>
  </el-dialog>
</template>

<script>
// import ImgUpload from './ImgUpload.vue'
  export default {
  // components: { ImgUpload },
    name: 'CourseEditForm',
    data () {
      return {
        dialogFormVisible: false,
        form: {
          id: '',
          name: '',
          coach_id: '',
          coach: '',
          classes: '',
          introduction: '',
          price: '',
          picture: '',
          video: ''
        },
        formLabelWidth: '120px'
      }
    },

    methods: {
      clear () {
        this.form = {
          id: '',
          name: '',
          coach_id: '',
          coach: '',
          classes: '',
          introduction: '',
          price: '',
          picture: '',
          video: ''
        }
      },

      updateCourse () {
        this.$axios
        .put('/course', {
          id: this.form.id,
          name: this.form.name,
          coach_id: this.form.coach_id,
          coach: this.form.coach,
          classes: this.form.classes,
          introduction: this.form.introduction,
          price: this.form.price,
          picture: this.form.picture,
          video: this.form.video
        })
        .then(response => {
          if (response.status === 200) {
            this.dialogFormVisible = false
            this.$emit('onSubmit')
          }
        })
      },

      // uploadImg () {
      //   this.form.picture = this.$refs.ImgUpload.url
      // }
    }
  }
</script>