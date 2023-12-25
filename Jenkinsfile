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
                } 
                nameBuildDocker = "${context}:${version_war}"
                
               
                sh "echo !!! ${version_war}"   
            }
        }
        stage('TESTES UNITARIOS BACKEND'){
            steps{
                sh 'mvn test'
            }
        }
       
        stage("DEPLOY BACKEND") {
           
            environment {
                IMAGEM_DOCKER_COMPOSE = "${nameBuildDocker}"
                DOCKER_COMPOSE_CONTAINER = "${context}_PRD"
            }  
            steps {
                sh "docker build -t ${nameBuildDocker} ."
                sh "docker-compose up"
            }
        }
        
    }
    
}