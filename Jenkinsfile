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
                 sh "${scannerHome}/bin/sonar-scanner -e -Dsonar.projectKey=deployBACK  -Dsonar.host.url=http://localhost:9000  -Dsonar.login=4d12036aa6a8c61d65cedff1661c6cefdff659dc -Dsonar.java.binaries=target"
                 
              }

            }
        }
        stage("Quality Gate") {
            steps {
              timeout(time: 1, unit: 'HOURS') {
                def logss waitForQualityGate abortPipeline: true
                sh "echo ${logss}"
              }
            }
        }
        
    }
    
}
