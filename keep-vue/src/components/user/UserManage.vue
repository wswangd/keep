<template>
    <div class="window">
        <div class="add-search">
            <div class="add">
                <el-button type="primary" @click="addUser">添加用户</el-button>
                <add-form @onAdd="loadUser" ref="add"></add-form>
            </div>
            <div class="search">
                <search-bar @onSearch='searchUser' ref="searchBar"></search-bar>
            </div>
        </div>
        
        <el-table
        class="table"
        :data="userTable"
        stripe
        style="width: 100%">
            <el-table-column
                prop="id"
                label="id"
                width="380">
            </el-table-column>
            <el-table-column
                prop="username"
                label="账号"
                width="380">
            </el-table-column>
            <el-table-column
                prop="password"
                label="密码"
                width="380">
            </el-table-column>
            <el-table-column
                label="操作"
                width="380">
            <template slot-scope="scope">
                <el-button @click="editUser(scope.row)" type="primary" size="small">修改</el-button>
                <el-button @click='deleteById(scope.row)' type="danger" size="small">删除</el-button>
                <edit-form @onSubmit='loadUser' ref="edit"></edit-form>
            </template>
            </el-table-column>
        </el-table>
        <!-- 分页 -->
        <div class="block">
            <span class="demonstration"> </span>
            <el-pagination
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
            :current-page="pageNum"
            :page-sizes="[5, 10, 50, 100]"
            :page-size="pageSize"
            layout="total, sizes, prev, pager, next, jumper"
            :total="total">
            </el-pagination>
        </div>
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
                pageNum: 1,
                pageSize: 5,
                total: 0
            }
        },

        mounted: function () {
            this.loadUser()
        },

        methods: {

            handleSizeChange(val) {
                this.pageSize = val
                this.searchUser()
            },
            handleCurrentChange(val) {
                this.pageNum = val
                this.searchUser()
            },

            loadUser () {
                var _this = this
                this.$axios.get('/user', {
                    params: {
                        pageNum: this.pageNum,
                        pageSize: this.pageSize
                    }
                })
                .then(response => {
                    if(response.status === 200) {
                        _this.userTable = response.data.list
                        _this.total = response.data.total
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
                this.$axios.get(url, {
                    params: {
                        pageNum: this.pageNum,
                        pageSize: this.pageSize
                    }
                })
                .then(response => {
                    if(response.status === 200) {
                        _this.userTable = response.data.list
                        _this.total = response.data.total
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