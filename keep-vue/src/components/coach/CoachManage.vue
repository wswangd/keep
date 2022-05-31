<template>
    <div>
        <el-button type="primary" @click="addCoach">添加教练</el-button>        <coach-search-bar @onSearch='searchCoach' ref="coachSearchBar"></coach-search-bar>
        <coach-add-form @onAdd="loadCoach" ref="addCoach"></coach-add-form>
        <el-table
        :data="coachTable"
        stripe
        style="width: 100%">
            <el-table-column
                prop="id"
                label="id"
                width="300">
            </el-table-column>
            <el-table-column
                prop="name"
                label="姓名"
                width="300">
            </el-table-column>
            <el-table-column
                prop="sex"
                label="性别"
                width="300">
            </el-table-column>
            <el-table-column
                prop="username"
                label="账号"
                width="300">
            </el-table-column>
            <el-table-column
                prop="password"
                label="密码"
                width="300">
            </el-table-column>
            <el-table-column
                label="操作"
                width="300">
            <template slot-scope="scope">
                <el-button @click="editCoach(scope.row)" type="primary" size="small">修改</el-button>
                <el-button @click="deleteById(scope.row)" type="danger" size="small">删除</el-button>
                <coach-edit-form @onSubmit='loadCoach' ref='coachEdit'></coach-edit-form>
            </template>
            </el-table-column>
        </el-table>
    </div>
</template>

<script>
    import CoachEditForm from './CoachEditForm.vue'
    import CoachAddForm from './CoachAddForm.vue'
    import CoachSearchBar from './CoachSearchBar.vue'
    export default {
        name: 'CoachManage',
        components: {
            CoachEditForm,
            CoachAddForm,
            CoachSearchBar
        },

        data () {
            return {
                coachTable: [],
            }
        },

        mounted: function () {
            this.loadCoach()
        },

        methods: {
            loadCoach () {
                var _this = this
                this.$axios.get('/coach')
                .then(response => {
                    if(response.status === 200) {
                        _this.coachTable = response.data
                    }
                })
            },

            searchCoach () {
                var url = '/coach/' + this.$refs.coachSearchBar.input
                var _this = this
                this.$axios.get(url)
                .then(response => {
                    if (response.status === 200) {
                        _this.coachTable = response.data
                    }
                })
            },

            editCoach (row) {
                this.$refs.coachEdit.dialogFormVisible = true
                this.$refs.coachEdit.form = {
                    id: row.id,
                    username: row.username,
                    password: row.password,
                    name: row.name,
                    sex: row.sex
                }
            },

            deleteById (row) {
                var url = '/coach/' + row.id
                this.$confirm('此操作将永久删除该教练，是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.$axios.delete(url)
                    .then(response => {
                        if(response.status === 200) {
                            this.loadCoach()
                        }
                    })
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消删除'
                    })
                })
            },

            addCoach () {
                this.$refs.addCoach.dialogFormVisible2 = true
            }
        },

        
    }
</script>

<style scoped>

</style>