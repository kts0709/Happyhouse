module.exports = {
    publicPath: '',
    outputDir: '../Backend/src/main/resources/static', // 빌드경로
    chainWebpack(config) { //빌드 시 빌드되어 나오는 js파일을 js폴더 아래로 묶어 빌드한다
      config.output.filename("js/app.js"); 
    },
  };
  