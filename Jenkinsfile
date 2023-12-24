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
                 withSonarQubeEnv('SONAR_SERVER_LOCAL') {
                  sh  "${scannerHome}/bin/sonar-scanner -e -Dsonar.projectKey=deploy-back  -Dsonar.host.url=http://localhost:9000/ -Dsonar.login=e9e2d622a1f63fdff76cb08b0972873064aabf4d  -Dsonar.java.binaries=target"
                 
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
