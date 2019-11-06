#!groovy
library 'jenkins-pipeline-libs@master'


pipeline {

  agent any
  
  stages {
    
    stage('Check previous builds') {
      steps {
        script {
          // println currentBuild.metaClass.methods.collect { it.name }
          println env.BRANCH_NAME
          println currentBuild.getChangeSets().each{ it.getId() }
          println currentBuild.previousBuild.previousBuild.metaClass.methods.collect { it.name }
          //def prevBuild = currentBuild.previousBuild
          //if (prevBuild)
          //    echo "Sending kill signal to build number: ${prevBuild.number}"
          //    prevBuild.rawBuild.doStop()
        }
      }
    }
    
    stage('Build Server Distribution') {
      steps {
        checkout scm
        sh './gradlew clean build'
      }
    }
  }
  
}
