<template>
    <div>
        <el-button type="primary" @click="addUser">添加用户</el-button>
        <add-form @onAdd="loadUser" ref="add"></add-form>
        <search-bar
        @onSearch='searchUser' ref="searchBar"></search-bar>
        <el-table
        :data="userTable"
        stripe
        style="width: 100%">
            <el-table-column
                prop="id"
                label="id"
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
                <el-button @click="editUser(scope.row)" type="primary" size="small">修改</el-button>
                <el-button @click='deleteById(scope.row)' type="danger" size="small">删除</el-button>
                <edit-form @onSubmit='loadUser' ref="edit"></edit-form>
            </template>
            </el-table-column>
        </el-table>
    </div>
</template>

<script>
    import EditForm from './EditForm'
    import SearchBar from './SearchBar'
    import AddForm from './AddForm'
    export default {
        name: 'UserManage',
        components: {
            EditForm,
            SearchBar,
            AddForm
        },

        data () {
            return {
                userTable: [],
            }
        },

        mounted: function () {
            this.loadUser()
        },

        methods: {
            loadUser () {
                var _this = this
                this.$axios.get('/user')
                .then(response => {
                    if(response.status === 200) {
                        _this.userTable = response.data
                    }
                })
            },

            deleteById (row) {
                var url = '/user/' + row.id
                this.$confirm('此操作将永久删除该用户，是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.$axios.delete(url)
                    .then(response => {
                        if(response.status === 200) {
                            this.loadUser()
                        }
                    })
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消删除'
                    })
                })
                
            },

            searchUser () {
                var url = '/user/' + this.$refs.searchBar.input
                var _this = this
                this.$axios.get(url)
                .then(response => {
                    if(response.status === 200) {
                        _this.userTable = response.data
                    }
                })
            },

            editUser (row) {
                this.$refs.edit.dialogFormVisible = true
                this.$refs.edit.form = {
                    id: row.id,
                    username: row.username,
                    password: row.password,
                }
            },

            addUser () {
                this.$refs.add.dialogFormVisible2 = true
            }
        },

        
    }
</script>

<style scoped>

</style>