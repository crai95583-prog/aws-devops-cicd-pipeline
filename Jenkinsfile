
pipeline {
    agent any

    tools {
        maven 'Maven-3.8.7'
    }

    environment {
        IMAGE_NAME = 'devops-cicd-app'
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out source code from GitHub'
                checkout scm
            }
        }

        stage('Build') {
            steps {
                dir('app') {
                    sh 'mvn clean package'
                }
            }
        }

        stage('Test') {
            steps {
                dir('app') {
                    sh 'mvn test'
                }
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t devops-cicd-app:latest .'
            }
        }

        stage('Pipeline Complete') {
            steps {
                echo 'Build and Docker image creation completed!'
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed. Check the console output.'
        }
    }
}
