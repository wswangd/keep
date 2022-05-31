<template>
    <div>
        <el-table
        :data="courseTable"
        stripe
        style="width: 100%">
            <el-table-column
                prop="id"
                label="id"
                width="300">
            </el-table-column>
            <el-table-column
                prop="name"
                label="课程名"
                width="300">
            </el-table-column>
            <el-table-column
                prop="coach_id"
                label="教练id"
                width="300">
            </el-table-column>
            <el-table-column
                prop="coach"
                label="教练"
                width="300">
            </el-table-column>
            <el-table-column
                prop="classes"
                label="课时"
                width="300">
            </el-table-column>
            <el-table-column
                prop="introduction"
                label="课程介绍"
                width="300">
            </el-table-column>
            <el-table-column
                prop="picture"
                label="图片"
                width="300">
                <template slot-scope="scope">
                    <img src="https://wswangd-1305336648.cos.ap-shanghai.myqcloud.com/yd_1.jpg" />
                </template>
            </el-table-column>
            <el-table-column
                prop="video"
                label="视频"
                width="300">
            </el-table-column>
            <el-table-column
                label="操作"
                width="300">
            <template slot-scope="scope">
                <el-button type="primary" size="small">修改</el-button>
                <el-button type="danger" size="small">删除</el-button>
            </template>
            </el-table-column>
        </el-table>
    </div>
</template>

<script>
    import CourseEditForm from './CourseEditForm.vue'
    import CourseAddForm from './CourseAddForm.vue'
    import CourseSearchBar from './CourseSearchBar.vue'
    export default {
        name: 'CourseManage',
        components: {
            CourseEditForm,
            CourseAddForm,
            CourseSearchBar
        },

        data () {
            return {
                courseTable: [],
            }
        },

        mounted: function () {
            this.loadCoach()
        },

        methods: {
            loadCoach () {
                var _this = this
                this.$axios.get('/course')
                .then(response => {
                    if(response.status === 200) {
                        _this.courseTable = response.data
                    }
                })
            },
        },

        
    }
</script>

<style scoped>

</style>