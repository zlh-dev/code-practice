# Git commit message 规范

在一个团队协作的项目中，开发人员需要经常提交一些代码去修复bug或者实现新的feature。而项目中的文件和实现什么功能、解决什么问题都会渐渐淡忘，最后需要浪费时间去阅读代码。但是好的日志规范commit messages编写有帮助到我们，它也反映了一个开发人员是否是良好的协作者。

目前有多种填写规范，但是使用最广的还是 Angular 规范

## Commit Message 的格式

包括三部分，Header,Body和Footer

```
<type>(<scope>): <subject>
// 换行
<body>
// 换行
<footer>
```

Header 是必需的，Body和Footer可以省略。尽量不要让每行超过72个字符，避免显示时换行影响美观。

## Header

Header包括三个字段：type（必需）、scope（可选）和subject（必需）

#### type

必填项，用来说明本次提交的类型，只能使用以下的一种：

```
# 主要type
feat:     增加新功能
fix:      修复bug

# 特殊type
docs:     只改动了文档相关的内容
style:    不影响代码含义的改动，例如去掉空格、改变缩进、增删分号
build:    构造工具的或者外部依赖的改动，例如webpack，npm
refactor: 代码重构时使用
revert:   执行git revert打印的message

# 暂不使用type
test:     添加测试或者修改现有测试
perf:     提高性能的改动
ci:       与CI（持续集成服务）有关的改动
chore:    不修改src或者test的其余修改，例如构建过程或辅助工具的变动
```

当一次改动包括`主要type`与`特殊type`时，统一采用`主要type`。

#### scope

必填项，用来说明本次改动的影响范围，如业务模块，类，界面等。格式为项目名/模块名，例如： `node-pc/common` `rrd-h5/activity`，而`we-sdk`不需指定模块名。如果一次commit修改多个模块，建议拆分成多次commit，以便更好追踪和维护。

#### subject

用来简单说明下本次改动，最好不要超过50个字。尽量以第一人称动词开头，结尾不加。好。第一个单词的首字母小写。

## Body

填写详细描述，主要描述`改动之前的情况`及`修改动机`，对于小的修改不作要求，但是重大需求、更新等必须添加body来作说明。可以分成多行，如：

```
.Fix small typo in docs widget (tutorial instructions)
.Fix test for scenario.Application - should remove old iframe
.docs - various doc fixes
.docs - stripping extra new lines
.Replaced double line break with single when text is fetched from Google
.Added support for properties in documentation
```

body也是用第一人称来书写，应该说明本次提交的动机，以及和之前的对比

## Footer

footer只有两种情况需要书写

1.不兼容的改动

若本次改动与上次改动不兼容，则footer应该以BREAKING CHANGE开头，后面加上变动的理由，描述和迁移的方法。如：

```
Before:

   scope: {
     myAttr: 'attribute',
     myBind: 'bind',
     myExpression: 'expression',
     myEval: 'evaluate',
     myAccessor: 'accessor'
   }

   After:

   scope: {
     myAttr: '@',
     myBind: '@',
     myExpression: '&',
     // myEval - usually not useful, but in cases where the expression is assignable, you can use '='
     myAccessor: '=' // in directive's template change myAccessor() to myAccessor
   }
```

2.关闭 Issue

若本次改动关闭了某个或多个Issue，那应该在footer中加以描述。如：

```
Closes #123, #245, #992
```

特殊状况：

1.Revert

如果当前 commit 用于撤销以前的 commit，则应该以revert:开头，后面跟着被撤销 Commit 的 Header。如;

```
revert: feat(view): add 'width' option

This reverts commit 667ecc1654a317a13331b17617d973392f415f02.

```

2.merge branch 和 修改冲突，git 会自动生成 commit msg.忽略就行了