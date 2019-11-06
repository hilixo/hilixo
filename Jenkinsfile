#!groovy
library 'jenkins-pipeline-libs@master'

static def discardPreviousBuilds(currentBuild, branchName, maxDepth = 5) {
    def previousBuild = currentBuild.previousBuild
    if(previousBuild != null && previousBuild.getResult() != null && branchName.startsWith("PR-")) {
        echo "Sending kill signal to build number: ${prevBuild.number}"
        previousBuild.rawBuild.doStop()
    }
    if(maxDepth > 0) {
        discardPreviousBuilds(previousBuild, branchName, maxDepth - 1)
    }
}

pipeline {

  agent any
  
  stages {
    
    stage('Check previous builds') {
      steps {
        script {
          // println currentBuild.metaClass.methods.collect { it.name }
          discardPreviousBuilds(currentBuild, env.BRANCH_NAME)
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
