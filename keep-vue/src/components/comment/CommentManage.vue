<template>
    <div class="window">  
        <div class="search">
            <comment-search-bar @onSearch="searchComment" ref="commentSearchBar"></comment-search-bar> 
        </div>
        <el-table
        class="table"
        :data="commentTable"
        stripe
        style="width: 100%">
            <el-table-column
                prop="id"
                label="id"
                width="250">
            </el-table-column>
            <el-table-column
                prop="course_id"
                label="课程编号"
                width="250">
            </el-table-column>
            <el-table-column
                prop="user_id"
                label="用户编号"
                width="250">
            </el-table-column>
            <el-table-column
                prop="context"
                label="评论"
                width="250">
            </el-table-column>
            <el-table-column
                prop="date"
                label="评论日期"
                width="250">
            </el-table-column>
            <el-table-column
                label="操作"
                width="250">
            <template slot-scope="scope">
                <el-button @click="deleteById(scope.row)" type="danger" size="small">删除</el-button>
            </template>
            </el-table-column>
        </el-table>
    </div>
</template>

<script>
    import CommentSearchBar from './CommentSearchBar.vue'
    export default {
        name: 'CommentManage',
        components: {
            CommentSearchBar
        },

        data () {
            return {
                commentTable: [],
            }
        },

        mounted: function () {
            this.loadComment()
        },

        methods: {
            loadComment () {
                var _this = this
                this.$axios.get('/comments')
                .then(response => {
                    if(response.status === 200) {
                        _this.commentTable = response.data
                    }
                })
            },

            deleteById (row) {
                var url = '/comments/' + row.id
                this.$confirm('此操作将永久删除该订单，是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.$axios.delete(url)
                    .then(response => {
                        if(response.status === 200) {
                            this.loadComment()
                        }
                    })
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消删除'
                    })
                })
            },

            searchComment () {
                var url = '/comments/' + this.$refs.commentSearchBar.input
                var _this = this
                this.$axios.get(url)
                .then(respose => {
                    if(respose.status === 200) {
                        _this.commentTable = respose.data
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
.search {
    margin-top: 1%;
}
.table {
    margin-top: 1%;
}
</style>