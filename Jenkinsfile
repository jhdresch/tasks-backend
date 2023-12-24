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
                 withSonarQubeEnv(installationName: "${scannerHome}/bin/sonar-scanner -e -Dsonar.projectKey=deploy-back  -Dsonar.host.url=http://localhost:9000/   -Dsonar.java.binaries=target",credentialsId:'477b84e4806907a79cb5521c8e6c5adb33bf4bbf') 
                
                 
              

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
