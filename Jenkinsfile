pipeline{
    agent any
    stages{
        stage('Build BACKEND'){
            steps{
                sh 'mvn clean package -DskipTests=true'
            }
        }
        stage('TESTES UNITARIOS BACKEND'){
            steps{
                sh 'mvn test'
            }
        }
        stage('SONAR ANALISES BACKEND'){
            environment {
                scannerHome = tool 'SONAR_SCANER'
            }           

            steps{
                 withSonarQubeEnv('SONAR_SERVER_LOCAL','477b84e4806907a79cb5521c8e6c5adb33bf4bbf',false) {
                  sh  "${scannerHome}/bin/sonar-scanner -e -Dsonar.projectKey=deploy-back  -Dsonar.host.url=http://localhost:9000/ -Dsonar.login=477b84e4806907a79cb5521c8e6c5adb33bf4bbf  -Dsonar.java.binaries=target"
                 
              }

            }
        }
        stage("Quality Gate") {
           
            steps {
          
              timeout(time: 1, unit: 'MINUTES') {
                     waitForQualityGate abortPipeline: true
     
              }
            }
        }
        
    }
    
}
