<template>
  <el-upload
  class="upload-image"
  action
  :http-request="getSignToken"
  :on-preview="handlePreview"
  :on-remove="handleRemove"
  :before-remove="beforeRemove"
  :limit="1"
  :on-exceed="handleExceed"
  :file-list="fileList">
  <el-button size="small" type="primary">点击上传</el-button>
  <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
  </el-upload>
</template>
<script>
  export default {
    data() {
      return {
        picture: ''
      };
    },

  // var COS = require('cos-js-sdk-v5');
  // var cos = new COS({
  //   // getAuthorization 必选参数
  //   getAuthorization: function (options, callback) {
  //       // 服务端例子：https://github.com/tencentyun/qcloud-cos-sts-sdk/blob/master/scope.md
  //       // 异步获取临时密钥
  //       var url = 'http://example.com/server/sts.php'; // url替换成您自己的后端服务
  //       var xhr = new XMLHttpRequest();
  //       xhr.open('POST', url, true);
  //       xhr.setRequestHeader('Content-Type', 'application/json');
  //       xhr.onload = function (e) {
  //           try {
  //               var data = JSON.parse(e.target.responseText);
  //               var credentials = data.credentials;
  //           } catch (e) {
  //           }
  //           if (!data || !credentials) {
  //               return console.error('credentials invalid:\n' + JSON.stringify(data, null, 2))
  //           };
  //           callback({
  //               TmpSecretId: credentials.tmpSecretId,
  //               TmpSecretKey: credentials.tmpSecretKey,
  //               SecurityToken: credentials.sessionToken,
  //               // 建议返回服务器时间作为签名的开始时间，避免用户浏览器本地时间偏差过大导致签名错误
  //               StartTime: data.startTime, // 时间戳，单位秒，如：1580000000
  //               ExpiredTime: data.expiredTime, // 时间戳，单位秒，如：1580000000
  //               ScopeLimit: true, // 细粒度控制权限需要设为 true，会限制密钥只在相同请求时重复使用
  //           });
  //       };
  //       xhr.send(JSON.stringify(options.Scope));
  //   }
  // });

    methods: {
      getSignToken() {

      },

      handleRemove(file, fileList) {
        console.log(file, fileList);
      },
      handlePreview(file) {
        console.log(file);
      },
      handleExceed(files, fileList) {
        this.$message.warning(`当前限制选择 1 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
      },
      beforeRemove(file, fileList) {
        return this.$confirm(`确定移除 ${ file.name }？`);
      }
    }
  }
</script>