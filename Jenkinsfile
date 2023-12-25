def version_war
def context
def nameBuildDocker
pipeline{
    agent any
    stages{
        stage('Build BACKEND'){
            steps{
                sh 'mvn clean package -DskipTests=true'
                script {
                    version_war = sh( script:'mvn help:evaluate -Dexpression=project.version -q -DforceStdout',returnStdout: true).trim()
                    context = sh( script:'mvn help:evaluate -Dexpression=project.name -q -DforceStdout',returnStdout: true).trim()
                    nameBuildDocker = "${context}:${version_war}"
                }               
               
                sh "echo !!! ${version_war}"   
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
              sleep(5)  
              timeout(time: 1, unit: 'MINUTES') {
                     waitForQualityGate abortPipeline: true
     
              }
            }
        }
        stage("DEPLOY BACKEND") {
           
            environment {
                IMAGEM_DOCKER_COMPOSE = nameBuildDocker;
                DOCKER_COMPOSE_CONTAINER = "${context}_PRD"

            }  
            steps {
                sh "docker build -t ${nameBuildDocker} ."
                sh "docker-compose up"
            }
        }
        
    }
    
}
