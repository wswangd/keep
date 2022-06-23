<template>
  <el-dialog 
  title="添加课程" 
  :visible.sync="dialogFormVisible2"
  @close="clear">
    <el-form :model="form">
      </el-form-item>
      <el-form-item label="课程名" :label-width="formLabelWidth">
        <el-input v-model="form.name" auto-complete="off"></el-input>
      </el-form-item>
      <el-form-item label="教练Id" :label-width="formLabelWidth">
        <el-input v-model="form.coach_id" auto-complete="off"></el-input>
      </el-form-item>
      <el-form-item label="教练" :label-width="formLabelWidth">
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
      </el-form-item>
      <!-- <el-form-item label="图片" :label-width="formLabelWidth">
        <el-input v-model="form.picture" auto-complete="off"></el-input>
        <img-upload @onUpload="uploadImg" ref="imgUpload"></img-upload>
      </el-form-item> -->
      <el-form-item label="视频" :label-width="formLabelWidth">
        <el-input v-model="form.video" auto-complete="off"></el-input>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="dialogFormVisible2 = false">取消</el-button>
      <el-button type="primary" @click="addCourse">确定</el-button>
    </div>
  </el-dialog>
</template>

<script>
import ImgUpload from './ImgUpload.vue'
  export default {
  components: { ImgUpload },
    name: 'CourseAddForm',
    data () {
      return {
        dialogFormVisible2: false,
        form: {
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

      addCourse () {
          this.$axios.post('/course', {
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
                  this.dialogFormVisible2 = false
                  this.$emit('onAdd')
              }
          })
      }

    }
  }
</script>