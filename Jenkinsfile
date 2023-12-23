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
                  sh 'mvn clean package sonar:sonar  -Dsonar.host.url=http://localhost:9000 -Dsonar.login=4d12036aa6a8c61d65cedff1661c6cefdff659dc  -Dsonar.java.binaries=target'
                 
              }

            }
        }
        stage("Quality Gate") {
             environment {
                scannerHome =  waitForQualityGate abortPipeline: false, credentialsId: '4d12036aa6a8c61d65cedff1661c6cefdff659dc'
            }  
           
            steps {
               sleep(5)  
              timeout(time: 1, unit: 'HOURS') {
             
     
              }
            }
        }
        
    }
    
}
