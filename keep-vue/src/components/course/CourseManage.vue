<template>
    <div class="window">
        <div class="add-search">
            <div class="add">
                <el-button type="primary" @click="addCourse">添加课程</el-button>
                <course-add-form @onAdd="loadCourse" ref="add"></course-add-form>
            </div>
            
            <div class="search">
                <course-search-bar @onSearch='searchCourse' ref="searchBar"></course-search-bar>
            </div>
        </div>
        
        <el-table
        class="table"
        :data="courseTable"
        stripe
        style="width: 100%">
            <el-table-column
                prop="id"
                label="id"
                width="165">
            </el-table-column>
            <el-table-column
                prop="name"
                label="课程名"
                width="165">
            </el-table-column>
            <el-table-column
                prop="coach_id"
                label="教练id"
                width="165">
            </el-table-column>
            <el-table-column
                prop="coach"
                label="教练"
                width="165">
            </el-table-column>
            <el-table-column
                prop="classes"
                label="课时"
                width="165">
            </el-table-column>
            <el-table-column
                prop="introduction"
                label="课程介绍"
                width="165">
            </el-table-column>
            <el-table-column
                prop="picture"
                label="图片"
                width="165">
                <template slot-scope="scope">
                    <el-image
                        style="width: 100px; height: 100px"
                        :src="scope.row.picture">
                    </el-image>
                </template>
            </el-table-column>
            <el-table-column
                prop="video"
                label="视频"
                width="165">
            </el-table-column>
            <el-table-column
                label="操作"
                width="165">
            <template slot-scope="scope">
                <el-button @click="editCourse(scope.row)" type="primary" size="small">修改</el-button>
                <el-button @click="deleteById(scope.row)" type="danger" size="small">删除</el-button>
                <course-edit-form @onSubmit="loadCourse" ref="courseEdit"></course-edit-form>
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
            CourseSearchBar,
        },

        data () {
            return {
                courseTable: [],
            }
        },

        mounted: function () {
            this.loadCourse()
        },

        methods: {
            loadCourse () {
                var _this = this
                this.$axios.get('/course')
                .then(response => {
                    if(response.status === 200) {
                        _this.courseTable = response.data
                    }
                })
            },

            editCourse (row) {
                this.$refs.courseEdit.dialogFormVisible = true
                this.$refs.courseEdit.form = {
                    id: row.id,
                    name: row.name,
                    coach_id: row.coach_id,
                    coach: row.coach,
                    classes: row.classes,
                    introduction: row.introduction,
                    price: row.price,
                    picture: row.picture,
                    video: row.video
                }
            },

            deleteById (row) {
                var url = '/course/' + row.id
                this.$confirm('此操作将永久删除该课程，是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.$axios.delete(url)
                    .then(response => {
                        if(response.status === 200) {
                            this.loadCourse()
                        }
                    })
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消删除'
                    })
                })
            },

            addCourse () {
                this.$refs.add.dialogFormVisible2 = true
            },

            searchCourse () {
                var url = '/course/' + this.$refs.searchBar.input
                var _this = this
                this.$axios.get(url)
                .then(response => {
                    if (response.status === 200) {
                        _this.courseTable = response.data
                    }
                })
            }
        },

        
    }
</script>

<style scoped>
.window {
    margin-top: 1%;
}
.add-search {
    display: flex;
}
.add {
    margin-left: 50px;
}
.search {
    margin-left: 20%;
}
.table {
    margin-top: 1%;
}
</style>