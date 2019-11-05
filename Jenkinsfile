library 'jenkins-pipeline-libs@master'

pipeline {

  agent none
  
  stages {
    stage('Build Server Distribution') {
      agent {
        label 'linux || xlr'
      }

      tools {
        jdk 'JDK 8u60'
      }

      steps {
        checkout scm
        sh './gradlew clean build'
      }
    }
  }
  
}
