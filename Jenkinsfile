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
                  sh 'mvn clean package sonar:sonar -Dsonar.projectKey=deploy-back -Dsonar.host.url=http://localhost:9000 -Dsonar.login=admin -Dsonar.java.binaries=target'
                 
              }

            }
        }
        stage("Quality Gate") {
           
            steps {
               sleep(5)  
              timeout(time: 1, unit: 'HOURS') {
                waitForQualityGate abortPipeline: true
              }
            }
        }
        
    }
    
}
