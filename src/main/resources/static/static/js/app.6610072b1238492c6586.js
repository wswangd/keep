webpackJsonp([1],{NHnr:function(t,e,o){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var n=o("7+uW"),a={render:function(){var t=this.$createElement,e=this._self._c||t;return e("div",{attrs:{id:"app"}},[e("router-view")],1)},staticRenderFns:[]};var i=o("VU/8")({name:"App"},a,!1,function(t){o("s347")},null,null).exports,l=o("/ocq"),r={render:function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"hello"},[e("h1",[this._v(this._s(this.msg))])])},staticRenderFns:[]};var s=o("VU/8")({name:"HelloWorld",data:function(){return{msg:"Welcome to Your Vue.js App"}}},r,!1,function(t){o("OuZt")},"data-v-46b62cc3",null).exports,c={render:function(){var t=this,e=t.$createElement,o=t._self._c||e;return o("body",{attrs:{id:"login-page"}},[o("el-form",{staticClass:"login-container",attrs:{"label-position":"left","label-width":"0px"}},[o("h3",{staticClass:"login_title"},[t._v("系统登录")]),t._v(" "),o("el-form-item",[o("el-input",{attrs:{type:"text","auto-complete":"off",placeholder:"账号"},model:{value:t.loginForm.loginName,callback:function(e){t.$set(t.loginForm,"loginName",e)},expression:"loginForm.loginName"}})],1),t._v(" "),o("el-form-item",[o("el-input",{attrs:{type:"password","auto-complete":"off",placeholder:"密码"},model:{value:t.loginForm.password,callback:function(e){t.$set(t.loginForm,"password",e)},expression:"loginForm.password"}})],1),t._v(" "),o("el-form-item",{staticStyle:{width:"100%"}},[o("el-button",{staticStyle:{width:"100%",border:"none"},attrs:{type:"primary"},on:{click:t.login}},[t._v("登录")])],1)],1)],1)},staticRenderFns:[]};var p=o("VU/8")({name:"Login",data:function(){return{loginForm:{loginName:"",password:""},responseResult:[]}},methods:{login:function(){var t=this;this.$axios.post("/login",{loginName:this.loginForm.loginName,password:this.loginForm.password}).then(function(e){200===e.data.code&&t.$router.replace({path:"/"})}).catch(function(t){})}}},c,!1,function(t){o("UyHI")},"data-v-79d65d3a",null).exports;n.default.use(l.a);var u=new l.a({mode:"history",routes:[{path:"/",name:"HelloWorld",component:s},{path:"/login",name:"Login",component:p}]}),d=o("zL8q"),m=o.n(d);o("tvR6");n.default.config.productionTip=!1,n.default.use(m.a);var f=o("mtWM");f.defaults.baseURL="http://localhost:80/api",n.default.prototype.$axios=f,new n.default({el:"#app",router:u,components:{App:i},template:"<App/>"})},OuZt:function(t,e){},UyHI:function(t,e){},s347:function(t,e){},tvR6:function(t,e){}},["NHnr"]);
//# sourceMappingURL=app.6610072b1238492c6586.js.map